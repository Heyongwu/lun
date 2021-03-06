package bwei.com.bangb;

import java.io.IOException;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取原始的请求数据
        Request orginRequest = chain.request();
        //先获取原始的请求参数，然后再拼接起来
        FormBody orginBody = (FormBody) orginRequest.body();
        FormBody.Builder builder = new FormBody.Builder();
        for (int i = 0; i < orginBody.size(); i++) {
            String name = orginBody.name(i);
            String value = orginBody.value(i);
            builder.add(name, value);
        }
        builder.add("source", "android");
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(orginRequest.url()).post(formBody).build();

        return chain.proceed(request);

    }
}