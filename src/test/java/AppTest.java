import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver(){
    return webDriver;
  }


  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void rootTest(){
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Yay! more Todo!!");
  }

  @Test
  public void createCategory(){
    goTo("http://localhost:4567/");
    click("a", withText("Add a new category"));
    fill("#name").with("stuff");
    submit(".btn");
    assertThat(pageSource()).contains("stuff");
  }

  @Test
    public void createTasksInACategoryPage() {
      Category myCategory = new Category("Banking");
      myCategory.save();
      goTo("http://localhost:4567/");
      click("a", withText("Banking"));
      click("a", withText("Add a new task"));
      fill("#description").with("do stuff");
      submit(".btn");
      assertThat(pageSource()).contains("do stuff");
    }

    @Test
    public void allTasksDisplayDescriptionOnCategoryPage() {
      Category myCategory = new Category("Banking");
      myCategory.save();
      Task firstTask = new Task("Steal money", myCategory.getId());
      firstTask.save();
      Task secondTask = new Task("Steal more money", myCategory.getId());
      secondTask.save();
      String categoryPath = String.format("http://localhost:4567/categories/%d", myCategory.getId());
      goTo(categoryPath);
      assertThat(pageSource()).contains("Steal money");
      assertThat(pageSource()).contains("Steal more money");
    }
}
