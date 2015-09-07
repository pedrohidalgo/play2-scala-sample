package features.steps

import cucumber.api.scala.{ ScalaDsl, EN }
import cucumber.api.DataTable
import cucumber.api.PendingException

class StepDefinitions extends ScalaDsl with EN{
    
  Given("""^my application is running$""") { () =>
    //// Write code here that turns the phrase above into concrete actions
//    throw new PendingException()
  }
  When("""^I go to the "([^"]*)" page$""") { (arg0: String) =>
    //// Write code here that turns the phrase above into concrete actions
//    throw new PendingException()
  }
  Then("""^I should see "([^"]*)"$""") { (arg0: String) =>
    //// Write code here that turns the phrase above into concrete actions
//    throw new PendingException()
  }

}
