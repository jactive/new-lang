
use actix_web::{get, post, web, App, HttpResponse, HttpServer, Responder};

#[get("/")]
async fn hello() -> impl Responder {
    HttpResponse::Ok()
        .content_type("text/html")
        .body(
            r#"
                <title>GCD Calculator</title>
                <from action="/gcd" method="post">
                    <input type="text" name="n" />
                    <input type="text" name="m" />
                    <button type="submit">Compute GCD</button>
                </form>
               "#,
         )
    // HttpResponse::Ok().body("Hello world!")
}

#[post("/echo")]
async fn echo(req_body: String) -> impl Responder {
    HttpResponse::Ok().body(req_body)
}

async fn manual_hello() -> impl Responder {
    HttpResponse::Ok().body("Hey there!")
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new()
            .service(hello)
            .service(echo)
            .route("/hey", web::get().to(manual_hello))
    })
    .bind(("127.0.0.1", 8080))?
    .run()
    .await
}

/*
use actix_web::{get, App, HttpResponse, HttpServer, Responder};


#[active_web::main]
async fn main() {
    let server = HttpServer::new(|| {
        App::new()
            .service(get_index)
    });

    println!("serving on http://localhost:3000 ...");
    server.bind("127.0.0.1", "3000")
        .expect("error binding to 127.0.0.1:3000")
        .run()
        .await
}

#[get("/")]
async fn get_index() -> impl Responder {
}

*/
