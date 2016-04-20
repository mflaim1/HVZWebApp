import controllers.SignUp;
import org.junit.Before;
import org.junit.Test;
import play.mvc.Result;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.FORBIDDEN;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.status;

/**
 * Created by mariahflaim on 4/15/16.
 */
public class SignUpTest {
    private String pass1;
    private String pass2;
    private String email;
    @Before
    public void setUp() {

        pass1 = "Password1";
        pass2 = "Password1";
        email = "npatel2@ithaca.edu";

    }
    @Test
    public void loadPage(){

    }
    @Test
    public void addUser(){

    }
    @Test
    public void validateSignUpWithBadEmail() {
        Result result = new SignUp().validateSignUp("myemail", pass1, pass2, "npatel2", "true");
        assertEquals(FORBIDDEN, status(result));
        assertEquals("email", contentAsString(result));
    }

    @Test
    public void validateSignUpWithBadPassword() {
        Result result1 = new SignUp().validateSignUp(email, "password", "password", "npatel2", "true");
        assertEquals(FORBIDDEN, status(result1));
        assertEquals("password", contentAsString(result1));
    }

    @Test
    public void validateSignUpWithMistmatchPasswords() {
        Result result2 = new SignUp().validateSignUp(email, "Password2", "pass2", "npatel2", "true");
        assertEquals(FORBIDDEN, status(result2));
        assertEquals("mismatch", contentAsString(result2));
    }
    @Test
    public void validateSignUpGoodInput() {
        Result result3 = new SignUp().validateSignUp(email, pass1, pass2, "npatel2", "true");
        assertEquals(OK, status(result3));
    }
    @Test
    public void repeatSignUpEmail(){
        Result result4;
        //assertEquals(FORBIDDEN, status(result4));
        //assertEquals("repeatE", contentAsString(result4));
        // ^^ asserts are accurate assuming an appropriate query can be made
        //not sure how to write these tests as they rely on checking against existing database entries
    }

    @Test
    public void repeatSignUpUname(){
        Result result5;
        //assertEquals(FORBIDDEN, status(result5));
        //assertEquals("repeatU", contentAsString(result5));
        // ^^ asserts are accurate assuming an appropriate query can be made
        //not sure how to write these tests as they rely on checking against existing database entries
    }
    @Test
    public void repeatSignUpUnameEmail(){
        Result result6;
        //assertEquals(FORBIDDEN, status(result6));
        //assertEquals("repeatUE", contentAsString(result6));
        // ^^ asserts are accurate assuming an appropriate query can be made
        //not sure how to write these tests as they rely on checking against existing database entries
    }
}
