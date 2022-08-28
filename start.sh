git checkout master
git pull

mvn clean package -P build-docker-image

docker-compose down
docker-compose kill
docker-compose pull
docker-compose up -d