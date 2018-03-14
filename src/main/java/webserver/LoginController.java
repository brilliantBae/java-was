package webserver;

public class LoginController extends AbstractController {

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        super.doPost(request, response);
        String userId = request.getParameter("userId");
        login(response, userId);
        return;
    }

    private void login(HttpResponse response, String userId) {
        if(db.findUserById(userId) != null){// 로그인 성공시
            response.responseWithCookie(true, "/index.html");
            return;
        }
        response.responseWithCookie(false, "/user/login_failed.html");
        return;
    }
}
