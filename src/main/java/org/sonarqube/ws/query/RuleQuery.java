/*
 * SonarQube PDF Report
 * Copyright (C) 2010-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarqube.ws.query;

import org.sonarqube.ws.client.services.Query;
import org.sonarqube.ws.model.Rules;

public class RuleQuery extends Query<Rules> {

	public static final String BASE_URL = "/api/rules/search?";

	private String ruleKey;

	public RuleQuery(String ruleKey) {
		setRuleKey(ruleKey);
	}

	@Override
	public String getUrl() {
		StringBuilder url = new StringBuilder(BASE_URL);
		url.append('?');
		appendUrlParameter(url, "rule_key", ruleKey);
		return url.toString();
	}

	@Override
	public final Class<Rules> getModelClass() {
		return Rules.class;
	}

	public static RuleQuery create(String ruleKey) {
		return new RuleQuery(ruleKey);
	}

	public String getRuleKey() {
		return ruleKey;
	}

	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}
}