# Adventist Dental Surgeries (ADS) - Appointment Management CLI

## Project Architectural Delivery
- **Java Runtime**: Version 24
- **Automation Build**: Maven 3.9+
- **CI/CD Pipeline**: GitHub Actions (`app-build.yml`)
- **Container Technology**: Docker (Multi-stage Architecture)

## Public Docker Image Registry URL
You can view or inspect the published container image here:
- **Docker Hub Repository**: [https://hub.docker.com/r/<your-dockerhub-username>/ads-appointment-cli](https://hub.docker.com/r/<your-dockerhub-username>/ads-appointment-cli)

## How to Pull and Run the Containerized Software

To pull the latest image and immediately run this CLI application on any machine without installing Java or Maven, execute the following commands:

```bash
# 1. Pull the image from public Docker Hub
docker pull <your-dockerhub-username>/ads-appointment-cli:latest

# 2. Execute the containerized application
docker run --rm <your-dockerhub-username>/ads-appointment-cli:latest