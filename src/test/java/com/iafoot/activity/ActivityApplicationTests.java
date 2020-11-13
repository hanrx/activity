package com.iafoot.activity;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ActivityApplicationTests {


	@Resource
	private ProcessEngineConfiguration configuration;
	@Resource
	private ProcessEngine engine;

	@Test
	public void contextLoads() {
		configuration.setDatabaseSchemaUpdate("drop-create");
		configuration.buildProcessEngine();
	}

	//添加角色用户
	@Test
	public void test() {
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		IdentityService is = engine.getIdentityService();
		// 添加用户组
		Group empGroup = saveGroup(is, "empGroup", "员工组");
		Group manageGroup = saveGroup(is, "manageGroup", "经理组");
		Group dirGroup = saveGroup(is, "dirGroup", "总监组");
		// 添加用户
		User empA = saveUser(is, "empa"); // 员工a
		User empB = saveUser(is, "empb"); // 员工b
		User managea = saveUser(is, "managea"); // 经理a
		User manageb = saveUser(is, "manageb"); // 经理b
		User dira = saveUser(is, "dira"); // 总监a
		// 绑定关系
		saveRel(is, empA, empGroup);
		saveRel(is, empB, empGroup);
		saveRel(is, managea, manageGroup);
		saveRel(is, manageb, manageGroup);
		saveRel(is, dira, dirGroup);
	}

	User saveUser(IdentityService is, String id) {
		User u = is.newUser(id);
		u.setPassword("123456");
		is.saveUser(u);
		return u;
	}

	Group saveGroup(IdentityService is, String id, String name) {
		Group g = is.newGroup(id);
		g.setName(name);
		is.saveGroup(g);
		return g;
	}

	void saveRel(IdentityService is, User u, Group g) {
		is.createMembership(u.getId(), g.getId());
	}

	//部署流程文件
	@Test
	public void test2() {
//	    / 无用 ： spring自动部署流程文件
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 存储服务
		RepositoryService rs = engine.getRepositoryService();
		Deployment dep = rs.createDeployment().addClasspathResource("processes/vacation.bpmn").deploy();
		ProcessDefinition pd = rs.createProcessDefinitionQuery().deploymentId(dep.getId()).singleResult();
		rs.addCandidateStarterGroup(pd.getId(), "empGroup");
	}

}
