#!/bin/bash

# Build Docker image
echo "🔧 Building Docker image..."
docker build -t java-docker-ci-project .

# Run container
echo "🚀 Running container..."
docker run --rm java-docker-ci-project
