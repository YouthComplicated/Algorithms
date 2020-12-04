package base.innerClassTest;

/**
 内部类：内部外部类的访问规则
 Inner class一般用在定义它的类或语句块之内，在外部引用它时必须给出完整的名称。
 Inner class的名字不能与包含它的类名相同；
 Inner class可以使用外部类的私有数据，因为它是外部类的成员，同一个类的成员之间可相互访问。
 而外部类要访问内部类中的成员需要:内部类.成员或者内部类对象.成员。
 分类：成员内部类（static成员内部类和非static成员内部类) 局部内部类（不谈修饰符）、匿名内部类

 内部类特性：
 Inner class作为类的成员：
 》》可以声明为final的    》》和外部类不同，Inner class可声明为private或protected；
 》》Inner class 可以声明为static的，但此时就不能再使用外层类的非static的成员变量；
 lInner class作为类：
 》》可以声明为abstract类 ，因此可以被其它的内部类继承
 【注意】非static的内部类中的成员不能声明为static的，只有在外部类或static的内部类中才可声明static成员。

 匿名内部类:
 匿名内部类不能定义任何静态成员、方法和类，只能创建匿名内部类的一个实例。一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。
 */