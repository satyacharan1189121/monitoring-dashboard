# Cloud Deployment Guide

This project is a Spring Boot application that requires a MySQL database.

## Files Prepared For Deployment

- `Dockerfile`: builds and runs the Spring Boot app in Docker.
- `.dockerignore`: keeps unnecessary local files out of the Docker image.
- `src/main/resources/application.properties`: reads database settings from environment variables.
- `src/main/java/com/monitoring/dashboard/controller/HealthController.java`: exposes `/health` for quick deploy checks.

## Required Environment Variables

Set these in your cloud provider:

```text
SPRING_DATASOURCE_URL=jdbc:mysql://YOUR_DB_HOST:3306/YOUR_DB_NAME
SPRING_DATASOURCE_USERNAME=YOUR_DB_USER
SPRING_DATASOURCE_PASSWORD=YOUR_DB_PASSWORD
PORT=8080
```

Most cloud platforms provide the `PORT` value automatically. If they do, you do not need to set it manually.

## Recommended: Railway

Railway is the simplest option for this project because it can host the Spring Boot app and MySQL database in the same project.

1. Commit and push these changed files to GitHub.
2. Open Railway and create a new project.
3. Choose "Deploy from GitHub repo".
4. Select this repository.
5. Add a MySQL database service.
6. Open the app service variables/settings.
7. Add:

```text
SPRING_DATASOURCE_URL=jdbc:mysql://MYSQL_HOST:MYSQL_PORT/MYSQL_DATABASE
SPRING_DATASOURCE_USERNAME=MYSQLUSER
SPRING_DATASOURCE_PASSWORD=MYSQLPASSWORD
```

Use the actual values Railway shows for the MySQL service. Do not type the placeholder names literally.

8. Deploy the app.

After deployment, test:

```text
https://YOUR_RAILWAY_APP_URL/health
https://YOUR_RAILWAY_APP_URL/
https://YOUR_RAILWAY_APP_URL/metrics/sample
https://YOUR_RAILWAY_APP_URL/metrics/all
```

Visit `/metrics/sample` once to insert sample data, then go back to `/` to see it on the dashboard.

## Alternative: Render

1. Commit and push these changed files to GitHub.
2. Create a MySQL database using a provider such as Aiven, PlanetScale, Railway, or AWS RDS.
3. In Render, create a new Web Service from the GitHub repository.
4. Choose Docker as the runtime.
5. Add the database environment variables listed above.
6. Deploy.

After deployment, test:

```text
https://YOUR_RENDER_APP.onrender.com/health
https://YOUR_RENDER_APP.onrender.com/
https://YOUR_RENDER_APP.onrender.com/metrics/sample
https://YOUR_RENDER_APP.onrender.com/metrics/all
```

## Local Docker Test

Build the image:

```powershell
docker build -t monitoring-dashboard .
```

Run it with a cloud or local MySQL database:

```powershell
docker run -p 8080:8080 `
  -e SPRING_DATASOURCE_URL="jdbc:mysql://YOUR_DB_HOST:3306/YOUR_DB_NAME" `
  -e SPRING_DATASOURCE_USERNAME="YOUR_DB_USER" `
  -e SPRING_DATASOURCE_PASSWORD="YOUR_DB_PASSWORD" `
  monitoring-dashboard
```

Then open:

```text
http://localhost:8080/health
http://localhost:8080/
```
