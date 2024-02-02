fn main() {
    println!("{}", gcd(111, 221));
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

#[test]
fn test_gcd( ){
    assert_eq!(gcd(14, 15), 1);
    assert_eq!(gcd(2 * 3 * 5 * 11 * 17,
                   3 * 7 * 11 * 13 * 19),
                   3 * 11);
}
