package com.aayach.developerApi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.repository.DeveloperRepository;
import com.aayach.developerApi.utility.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestExecutionListeners(listeners = DeveloperApiControllerTest.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class DeveloperApiControllerTest extends AbstractTestExecutionListener {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private DeveloperRepository developerRepository;

	private MockMvc mockMvc;

	private static final String SERVICE_URI = "/DeveloperApi/developer";

	private static long getDeveloperDatasetID;

	private static long updateDeveloperDatasetID;


	private static Developer getDeveloperDataset;

	private static Developer updateDeveloperDataset;

	private static Developer deleteDeveloperDataset;

	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		developerRepository = testContext.getApplicationContext().getBean(
				DeveloperRepository.class);
		getDeveloperDataset = new Developer();
		getDeveloperDatasetID = developerRepository
				.saveDeveloper(getDeveloperDataset);
		updateDeveloperDataset = new Developer();
		updateDeveloperDatasetID = developerRepository
				.saveDeveloper(updateDeveloperDataset);
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		developerRepository.deleteDeveloper(getDeveloperDatasetID);
		developerRepository.deleteDeveloper(updateDeveloperDatasetID);
	}

	@Test
	@Rollback(true)
	@Commit
	@Transactional
	public void testSaveDeveloper() throws Exception {
		String jsonload = " { \"name\": \"testdevname\",\"FirstName\": \"testdevFirstname\" }";
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = this.mockMvc
				.perform(
						post(SERVICE_URI)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON_UTF8)
								.content(jsonload)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Developer responseDeveloper = objectMapper.readValue(jsonResponse,
				Developer.class);
		Assert.assertNotNull(responseDeveloper.getId());
	}

	@Test
	public void testGetDeveloper() throws Exception {
		String jsonResponse = this.mockMvc
				.perform(
						get(SERVICE_URI + "/" + getDeveloperDatasetID)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		Developer responseDeveloper = objectMapper.readValue(jsonResponse,
				Developer.class);
		Assert.assertNotNull(responseDeveloper.getId());
		Assert.assertTrue(Constants.SUCCESS_SAVE_MESSAGE.equals(jsonResponse));
	}

	@Test
	public void testUpdateDeveloper() throws Exception {
		String jsonload = " { \"name\": \"testupdname\"}";
		;
		String jsonResponse = this.mockMvc
				.perform(
						put(SERVICE_URI + "/" + updateDeveloperDatasetID)
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON_UTF8)
								.content(jsonload)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Assert.assertTrue(Constants.SUCCESS_UPDATE_MESSAGE.equals(jsonResponse));
	}

	@Test
	public void testDeleteOrder() throws Exception {
		long id = deleteDeveloperDataset.getId();
		this.mockMvc.perform(
				delete(SERVICE_URI + "/" + id).contentType(
						MediaType.APPLICATION_JSON).accept(
						MediaType.APPLICATION_JSON_UTF8)).andExpect(
				status().isOk());
		Assert.assertNull(developerRepository.getDeveloperbyId(id));
	}

}
