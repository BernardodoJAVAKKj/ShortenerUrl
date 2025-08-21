
## Features
- Shorten long URLs into cleaner versions.
- Simple and lightweight API.
- Built with Java and Spring Boot.

## Endpoint

### Shorten a URL
**Request**  
GET http://localhost:8080/api/url/encurtar?url={LONG_URL}

markdown
Copiar
Editar

**Parameters**
- `url` *(string, required)*: The URL you want to shorten.

**Example**
GET http://localhost:8080/api/url/encurtar?url=https://www.google.com

pgsql
Copiar
Editar

**Response**
```json
{
  "originalUrl": "https://www.google.com",
  "shortenedUrl": "http://localhost:8080/api/url/abc123"
}
Running the Project
Clone the repository:

bash
Copiar
Editar
git clone https://github.com/your-username/url-shortener-java.git
Navigate into the project:

bash
Copiar
Editar
cd url-shortener-java
Run the application (Spring Boot):

bash
Copiar
Editar
mvn spring-boot:run
Access the API at:

bash
Copiar
Editar
http://localhost:8080/api/url/encurtar?url=https://example.com
