console.log("hello world 3")

let a1: number = 1 // 类型系统：显示注解类型
let b1: string = 'hello'
let c1: boolean[] = [true, false]

let a2 = 1 // 类型系统：隐式推导类型
let b2 = 'hello'
let c2 = [true, false]

//! Type 'string' is not assignable to type 'number'.ts(2322)
// a2 = "hello"