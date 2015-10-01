// add some comments
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", " the main activity started");
        //找到button的id, 为该button设置OnClickListener, 在onClick函数里开启另外一个Activity
        findViewById(R.id.button_open_url).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.163.com")));
            }
        });
    }
  //也可以直接在layout XML文件里设置点击button时执行的函数为start2Act
  // android:onClick = "start2Act"/>
        public void start2Act(View view)
    {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
