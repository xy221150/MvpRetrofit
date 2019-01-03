package com.example.edz.mvpretrofit.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by wxy on 2018/5/11.
 */

public class LogInterceptor implements Interceptor {
    private final static String TAG="LogInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request= chain.request();
        Request newRequset;
        Request.Builder builder=request.newBuilder();
        //token
//        String sessionId= User.user().getToken();
//        if (!TextUtils.isEmpty(sessionId))
//        {
//            sessionId="JSESSIONID= "+sessionId;
//            builder.header("Cookie",sessionId);
//        }
        newRequset=builder.header("Content-Type","application/json")
                .header("Accepe","application/json").build();
        String url=newRequset.url().toString();
        String hearder=newRequset.headers().toString();
        Response response=chain.proceed(newRequset);
        okhttp3.MediaType mediaType=response.body().contentType();
        String content=response.body().toString();

        return response.newBuilder().build();
    }

}
