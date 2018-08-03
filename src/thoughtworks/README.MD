# 迷宫生成
Created by Airy on 2018/7/29
## 运行方法
* 运行主程序
```java
String size = in.nextLine();
String connect = in.nextLine();
String command = size+"\n"+connect;
try {
    Maze maze = MazeFactory.Create(command);
    if (maze!=null){
        System.out.println(maze.render());
    } else {
        System.out.println("null maze");
    }
}catch (Exception e){
    e.printStackTrace();
}        
```

* 输入样例数据
```
3 3
0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
```

* 得到结果（即渲染成字符）
```
[W] [W] [W] [W] [W] [W] [W] 
[W] [R] [W] [R] [R] [R] [W] 
[W] [R] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [R] [R] [W] 
[W] [W] [W] [R] [W] [R] [W] 
[W] [R] [R] [R] [W] [R] [W] 
[W] [W] [W] [W] [W] [W] [W] 
```

## 程序思想
 1. 使用二维数组进行迷宫的储存
 2. 输入的row和col和最终生成的长度有 row || col = 2*(row || col)+1 的关系
 3. 由于只能点与点之间只能正向相邻相连而且不能联通路上不能有其他的点，
    故判断其点之间的距离是否等于一并且判断其x轴或y轴是否有一个是相等的
    ```java
    public boolean isFormat(int row,int col){
        if (this.x1<0 || this.x1>col || this.x2<0 || this.x2>col ||
                this.y1<0 || this.y1>row || this.y2<0 || this.y2>row ) // 边界判断
            return false;
        else if (this.x1 == this.x2 || this.y1 == this.y2){
            if (Math.abs(this.x1-this.x2) == 1 || Math.abs(this.y1-this.y2) == 1){ // 判断是否正向相邻
                return true;    
            }
        }
        return false;    
    }        
    ```
 4. 按照以上要求生成正确的点，将其联通再进行字符输出
 5. 错误捕获输出其错误语句
    * 判断抛出异常的字符串内容进行判断是何种类型的错误

## 检查输入的有效性
 * 无效的数字 && 数字超出预定范围
 ```java
 // 对Integer.valueOf进行包装，判断转换数字是否小于0，生成异常将其抛出
 // 利用valueOf方法抛出的NumberFormatException来判断无效的数字
 private static int stringToInt(String s) throws Exception {
    try {
        int result = Integer.valueOf(s);
        if (result < 0){
            throw new Exception("range");
        }
        return result;
    }catch (NumberFormatException e){
        throw new Exception("number");
    }
 }
 ```
 * 格式错误
  ```java
  //使用正则表达式判断是否符合要求,而且不直接匹配数字，数字转换交给另一个函数负责
  // 如下
  private static String sizePattern = "-?\\S+\\s-?\\S+";
  // 判断迷宫格式是否正确
  private static String connectPattern = "^(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+;)*(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+)$";
  // 判断联通数据格式是否正确
  ```
 * 连通性错误
  ```java
  // 代码如程序思想3所示
  ```