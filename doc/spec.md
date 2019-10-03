

The types system is divided into two groups:
* ```primitives types```
* custom types
* raw pointer


# Primitives
The ```primitives``` types consist of two subgroups:

## Scalar Types
|Type|Description|
|---|---|
|signed integers|```i8```, ```i16```, ```i32```, ```i64``` and ```isize``` (pointer size)|
|unsigned integers|u8, u16, u32, u64, u128 and usize (pointer size)|
|floating point|f32, f64|
|char|Unicode scalar values like 'a', 'α' and '∞' (4 bytes each)|
|bool|either true or false| 
|unit|the unit type (), whose only possible value is an empty tuple: ()| 
 
 
Despite the value of a unit type being a tuple, it is not considered a compound type because it does not contain multiple values.

### The Boolean Type
A Boolean type in KSrc has two possible values: true and false. Booleans are one byte in size. The Boolean type in KSrc is specified using bool. For example:

```
fn main:
  let t = true;
  let f bool = false; // with explicit type annotation
}
```

The main way to use Boolean values is through conditionals, such as an if expression. We’ll cover how if expressions work in KSrc in the “Control Flow” section.


## Compound Types

Compound types can group multiple values into one type. KSrc has two primitive compound types: tuples and arrays.

|Type|Description|
|---|---|
|arrays|like [1, 2, 3]|
|tuples|like (1, true)|


### The Array Type
Another way to have a collection of multiple values is with an array. Unlike a tuple, every element of an array must have the same type. Arrays in KSrc have a fixed length, like tuples.

# Custom Types
In addition to the primitives types, it is also possible to declare custom data types are formed mainly through the two keywords:

struct: define a structure
enum: define an enumeration

## Raw Pointer

A raw pointer is a pointer without safety or liveness guarantee. Raw pointers are written as *const T or *mut T, for example *const i32 means a raw pointer to a 32-bit integer. Copying or dropping a raw pointer has no effect on the lifecycle of any other value. Dereferencing a raw pointer is an unsafe operation, this can also be used to convert a raw pointer to a reference by reborrowing it (&* or &mut *). Raw pointers are generally discouraged in KSrc code; they exist to support interoperability with foreign code, and writing performance-critical or low-level functions.

When comparing pointers they are compared by their address, rather than by what they point to. When comparing pointers to dynamically sized types they also have their addition data compared. 