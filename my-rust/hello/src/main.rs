// import FromStr trait. A trait is a collection of methods like j.interface
// FromStr trait defines an abstract method, u64::from_str
// FromStr trait must be imported, although it is never used elsewhere
use std::str::FromStr;
// import std::env module. env::args() is a function to access cmd args
use std::env;

fn main() {
    // mut tells Rush to allow calling numbers.push
    // numbers declaration would better to be
    //    let mut numbers: Vec<u64> = Vec::new();
    // however, Rust is not picky. Rust can infer Vec<u64>.
    // Rust will complain about different type of values pushed into numbers
    let mut numbers = Vec::new();
    
    // env is imported by `use std::env`
    for arg in env::args().skip(1) {
        // u64::from_str is static method of u64 type
        // imported/weaved_in by `use std::str::FromStr`.
        //
        // u64::from_str doesn’t return a u64 directly,
        // but rather a *Result* value that indicates
        // whether the parse succeeded or failed.
        // Result is an enum, either Ok(v) or Err(e)
        // OK(v).expect(&str) returns the parsed u64 value
        numbers.push(u64::from_str(&arg)
                      .expect("error parsing argument"));
    }

    if numbers.len() == 0 {
        eprintln!("Usage: gcd Number ...");
        std::process::exit(1);
    }

    let mut d = numbers[0];
    // &numbers[1..] lets m borrow the reference of the
    // elements in numbers
    // *m dereferences the reference, yielding the value
    // referenced by m
    for m in &numbers[1..] {
         d = gcd(d, *m);
    }

    // println! is a macro that takes a template string
    println!("The greatest common divisor {:?} is {}", numbers, d);
}

fn gcd(mut n: u64, mut m: u64) -> u64 {
    // assert! macro
    // The ! character says assert! is a macro invocation, not a function call
    // if it is false, terminates the program with a helpful message including
    // the source location of the failing check (panic)
    assert!(n != 0 && m != 0);
    // while/if does require curl bracket, but not parentheses around condition
    while m != 0 {
        if m < n {
            // infer t is a u64 like m
            // Rust only infers types within function bodies
            let t = m;
            m = n;
            n = t;
        }

        m = m % n;
    }
    // If a function body ends with an *expression* that is
    // not followed by a semicolon, that’s the function’s return value.
    n
}

// #[test] marker is an attribute (annotation in Java)
#[test]
fn test_gcd( ){
    assert_eq!(gcd(14, 15), 1);
    assert_eq!(gcd(2 * 3 * 5 * 11 * 17,
                   3 * 7 * 11 * 13 * 19),
                   3 * 11);
}
