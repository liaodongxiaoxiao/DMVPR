# DMVPR
Dagger2+MVP+Retrofit Demo

## 用到的知识点
### Retrofit相关知识
- get请求
	*	RESTful 格式的请求
	```java
    @GET("/cook/list/{page}")
    Call<List<MenuList>> getMenuList(@Path("issue") int page);
    // 最终请求的URL http://api.baidu.com/tngou/cook/list/1
    ```
    * 普通的以&符拼接的请求
    ```java
    @GET("/cook/list")
    Call<List<MenuList>> getMenuList(@Query("page") int page);
    // 最终请求的URL http://api.baidu.com/tngou/cook/list?page=1
    ```
### gradle 脚本中常量的定义
- resValue
	```java
    //build.gradle
    resValue 'string', 'BASE_HOST', 'http://192.168.1.150:8080/test/service/'
    //java 代码中获取
    context.getResources().getString(R.string.BASE_HOST);
    ```
- buildConfigField
	```java
    //build.gradle
    buildConfigField "long", "BUILD_TIME", System.currentTimeMillis()+"L"
    //java 代码中获取
    public Date getAppBuildDate() {
        return new Date(BuildConfig.BUILD_TIME);
    }
    /**
     * buildConfigField 定义时需要拼完整串
     * buildConfigField "类型"，"常量名称"，"常量值"
     */
	```

### 其他点
- 全屏
	```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        ...
    }
    ```


## 参考项目
- [retro-dagger-example](https://github.com/fr4nk1/retro-dagger-example)
- [Dagger2Sample](https://github.com/niuxiaowei/Dagger2Sample)
