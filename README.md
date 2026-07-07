**Talent Cloud Services – Holiday & Payment Microservices**  

 Modular Spring Cloud architecture using Java 21, Eureka, OpenFeign.  
 
 Three modules: **eureka‑server (8761)**, **holiday‑service (8081)**, **payment‑service (8082)**.  
 
 Eureka serves as service registry; both microservices register with it upon startup.  
 Holiday Service exposes public holidays and their rate multipliers for premium pay.  
 Payment Service calculates daily wages, consulting the holiday list via Feign discovery.  

**Build & Run**  

 Build all modules with Maven Wrapper: `./mvnw clean package -DskipTests`.  
 Launch in order: start Eureka → Holiday Service → Payment Service.  
 Verify registrations on the Eureka UI at http://localhost:8761.  

**Holiday Service API**  

 GET `/api/holidays` – list all holidays for the current year (JSON array).
 GET `/api/holidays/{date}` – return holiday details or 404 if not a holiday.  
 GET `/api/holidays/check?date=YYYY‑MM‑DD` – simple true/false check.  

**Payment Service API**  

 GET `/api/payments/calculate?baseDailyRate=x&date=y` – quick calculation, returns JSON with multiplier info.  
 Example: Christmas Day → `rateMultiplier 2.0`, calculated payment doubled.  
 Example: Regular day → `isHoliday=false`, multiplier 1.0, base rate applied.  
 POST `/api/payments/calculate` – accepts `{baseDailyRate,date}` JSON body for calculation.  

**Operational Notes**  

 Payment Service uses Eureka to locate Holiday Service instances automatically.  
 Sample cURL for POST shown: `curl -X POST http://localhost:8082/api/payments/calculate …`.  
 All services are Spring Boot applications; Java 21 is required.  
 Documentation provides example responses and endpoint usage for quick testing.  
 This setup enables dynamic holiday-based pay calculation in a microservices environment.

