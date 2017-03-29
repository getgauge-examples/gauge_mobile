/*
 * Copyright 2012-2013 eBay Software Foundation and selendroid committers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.demo.webui;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Base Test to demonstrate how to test hybrid android apps with Selendroid. App under test is:
 * <code>src/main/resources/employee-directory.apk</code> Please make sure that you start a
 * selendroid-standalone with above mentioned apk.
 *
 * @author ddary
 */
public class EmployeeDirectoryTest {

    @Step("Open Employee Directory in web view")
    public void openEmployeeDirectory() throws Exception {
        WebDriver driver = Driver.webDriver;
        driver.get("and-activity://io.selendroid.directory.EmployeeDirectory");
        driver.switchTo().window("WEBVIEW");
    }

    @Step("Find employee <name> with id <id>")
    public void findEmployee(String name, String id) throws Exception {
        WebDriver driver = Driver.webDriver;

        driver.findElement(By.tagName("input")).sendKeys(name);
        driver.findElement(By.partialLinkText(name)).click();
        Assert.assertEquals(driver.getCurrentUrl(), "file:///android_asset/www/index.html#employees/"+id);
    }

    @Step("Verify the Manager <name>")
    public void verifyManager(String name) throws Exception {
        WebDriver driver = Driver.webDriver;

        Assert.assertThat(driver.findElements(By.tagName("li")).get(0).getText(),
                endsWith(name));
    }

    @Step("Verify number of direct reports of employee with id <id> is <number>")
    public void verifyNumberOfDirectReports(String id, String number) throws Exception {
        WebDriver driver = Driver.webDriver;

        // Verify number of direct reports
        WebElement directs = driver.findElements(By.tagName("li")).get(1);
        Assert.assertThat(directs.getText(), endsWith(number));
        directs.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "file:///android_asset/www/index.html#employees/" + id + "/reports");
    }

    @Step("Verify the reportees of employee with id <id> are <reportees>")
    public void verifyNumberOfDirectReports(String id, Table reportees) throws Exception {
        WebDriver driver = Driver.webDriver;

        List<TableRow> tableRows = reportees.getTableRows();
        for (int i=0;i< tableRows.size();i++)
        {
            Assert.assertThat(driver.findElements(By.tagName("li")).get(i).getText(),
                    startsWith(tableRows.get(i).getCell("name")));
        }
        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "file:///android_asset/www/index.html#employees/4");
    }
}
