《Kotlin for Android Developers》

the advantages of the language
- it is more expressive.
- it's safer.
- it's functional.
- it makes use of extension function.
- it's highly interoperable.

- Expresiveness
```
data class Artist(
        var id: Long,
        var name: String,
        var url: String,
        var mbid: String
)

```

- Null Safety
```
// Use Elvis operator(?:) to give an alternative in case the object is null.
val name = artist?.name ?: "empty"

```

两种方式：?:和?.
- Extension functions




其他的位操作，如shl,shs,ushr,xor or inv


Kotlin中的properties可以理解为java中的fields,但前者更强大.


Anko[https://github.com/Kotlin/anko] 是JetBrains开发的一个用于代替xml直接在代码中设置布局的库。

## 7.3 Extension functions扩展函数
extension function acts as if it belonged to the class.

# 9 Data Classes


## 13.3 Extending the language
- with函数
- inline函数 


# 14 Visibility Modifiers可见性修饰符

## 14.1 Modifiers
- private 
- protected
- internal
- public



## 16.3 Standard Delegates
lateinit 修饰符允许声明非空类型，并在对象创建后(构造函数调用后)初始化。 不使用 lateinit 则需要声明可空类型并且有额外的空安全检测操作
 
 
 
 
# 18 集合和函数操作
- Iterable
- MutableIterable
- Collection
- MutableCollection
- List
- MutableList
- Set
- MutableSet
- Map
- MutableMap


## 18.1 Aggregate operation
- any
- all
- count
- fold
- foldRight
- forEach
- forEachIndexed
- max
- maxBy
- min
- minBy
- none
- reduce
- reduceRight
- sumBy

## 18.2 过滤操作
- drop
- dropWhile
- dropLastWhile
- filter
- filterNot
- filterNotNull
- slice
- take
- takeLast
- takeWhile

## 18.3 合并操作
- flatMap
- groupBy
- map
- mapIndexed
- mapNotNull


## 18.4 Elements Operation
- contains
- elementAt
- elementAtOrElse
- elementAtOrNull
- first
- firstOrNull
- indexOf
- indexOfFirst
- indexOfLast
- last
- lastIndexOf
- lastOrNull
- single
- singleOrNull


## 18.5 Generation Operation
- merge
- partition
- plus
- zip
- unzip

## 18.6 Ordering Operation
- reverse
- sort
- sortBy
- sortDescending 
- sortDescendingBy    


# 19 保存数据和获取数据到数据库



# 20 Null safety in Kotlin

- !! operator
```
val a :Int? = null
a!!.toString()
```

# 22 Flow control and ranges

## 22.1 if 表达式
```
 val z = if(condition) x else y
```

## 22.2 when表达式

```
while(x){
    1 -> print("x == 1")
    2 -> print("x == 2")
    else -> {
        print("i am a block")
        print("x is neither 1 nor 2")

    }
}

```


作为表达式的话
```
val result = when(x){
    0,1 -> "binary"
    else -> "error"

}
```

## 22.3 For loops






