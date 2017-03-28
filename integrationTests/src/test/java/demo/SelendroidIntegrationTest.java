/*
 * Copyright 2012-2014 eBay Software Foundation and selendroid committers.
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
package demo;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import driver.DriverFactory;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelendroidIntegrationTest {

  @Step("enter text <input>")
  public void enterText(String input) {
    WebElement inputField = Driver.webDriver.findElement(By.id("my_text_field"));
    inputField.sendKeys("Selendroid");
  }

  @Step("Verify <Gauge> is entered")
  public void VerifyInputIsEntered(String input) {
    WebElement inputField = Driver.webDriver.findElement(By.id("my_text_field"));
    Assert.assertEquals("Selendroid", inputField.getText());
  }
}
