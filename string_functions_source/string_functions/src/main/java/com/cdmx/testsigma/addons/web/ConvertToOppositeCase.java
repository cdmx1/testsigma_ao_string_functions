

/* Change Logs: General Task | Function to convert a string to the opposite case (lower to upper and vice versa) | 16/11/23 */


package com.cdmx.testsigma.addons.web;

import com.testsigma.sdk.WebAction;

import com.testsigma.sdk.ApplicationType;
import com.testsigma.sdk.Result;
import com.testsigma.sdk.annotation.Action;
import com.testsigma.sdk.annotation.TestData;
import com.testsigma.sdk.annotation.Element;
import com.testsigma.sdk.annotation.RunTimeData;
import lombok.Data;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

@Data
@Action(actionText = "Convert Testdata to opposite case and store it in a runtime variable",
        description = "validates options count in a select drop-down",
        applicationType = ApplicationType.WEB)
public class ConvertToOppositeCase extends WebAction {

  @TestData(reference = "Testdata")
  private com.testsigma.sdk.TestData testData;
  
  @TestData(reference = "variable")
  private com.testsigma.sdk.TestData runtimeVar;
  
  @RunTimeData
  private com.testsigma.sdk.RunTimeData runTimeData;

  @Override
  public com.testsigma.sdk.Result execute() throws NoSuchElementException {
    //Your Awesome code starts here
    logger.info("Initiating execution");
    com.testsigma.sdk.Result result = com.testsigma.sdk.Result.SUCCESS;
    try 
    {
    	logger.debug("Testdata => " + testData.getValue().toString());
    	
    	String var_original_string = testData.getValue().toString();

        StringBuilder s = new StringBuilder();

       for (int i = 0; i < var_original_string.length(); i++) {
           char c = var_original_string.charAt(i);
           
           if (Character.isUpperCase(c)) {
               s.append(Character.toLowerCase(c));
           } else if (Character.isLowerCase(c)) {
               s.append(Character.toUpperCase(c));
           } else {
               s.append(c);
           }
       }
       
       String res = s.toString();
       
       runTimeData.setKey(runtimeVar.getValue().toString());
       runTimeData.setValue(res);
       
       result = Result.SUCCESS;
       setSuccessMessage("Successfully converted " + var_original_string + " to " + res + " and stored in runtime variable");
    }
    catch (Exception e) 
    {
        result = com.testsigma.sdk.Result.FAILED;
        setErrorMessage(errorMessage);
	} 
    return result;
  }
}