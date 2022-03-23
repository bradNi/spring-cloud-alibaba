/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.sentinel.datasource;

import com.alibaba.cloud.sentinel.datasource.config.ApolloDataSourceProperties;
import com.alibaba.cloud.sentinel.datasource.config.DataSourcePropertiesConfiguration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="mailto:i@5icodes.com">hnyyghk</a>
 */
public class DataSourcePropertiesConfigurationTests {

	@Test
	public void testGetValidField() {
		DataSourcePropertiesConfiguration configuration = new DataSourcePropertiesConfiguration();
		ApolloDataSourceProperties apollo = new ApolloDataSourceProperties();
		apollo.setNamespaceName("application");
		apollo.setFlowRulesKey("test-flow-rules");
		apollo.setDefaultFlowRuleValue("[]");
		apollo.setDataType("json");
		apollo.setRuleType(RuleType.FLOW);
		configuration.setApollo(apollo);

		List<String> validField = configuration.getValidField();

		assertThat(validField.size()).isEqualTo(1);
		assertThat(validField).doesNotContain("$jacocoData");
		assertThat(validField).contains("apollo");
	}

}
