package com.bigdata.day1

/**
  * @author : wangshengyu 
  * @date : 2019/5/2 
  */
//private[bigdata] 只能在day2包下的访问
//private[bigdata] class Person {
class Person {
  //val修饰的变量只有只读属性，有getter()没有setter()
  //相当于Java中的final修饰的变量
  val id = "9527"

  // var修饰的变量既有getter()也有setter()
  var age = 18

  // 类私有字段，只能在类内部使用
  private var name = "唐伯虎"

  //对象私有字段，访问权限更加严格，Person的方法只能访问当前对象的字段
  private[this] val pet = "小强"

  def getPet: Unit ={
    println(pet)
  }
}

//Person类的伴生对象
object Person{
  def main(args: Array[String]): Unit = {
    val p = new Person
    println(p.name)
    p.getPet

  }
}