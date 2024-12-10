FROM node:20-alpine
LABEL authors="Méhes Nándor"

WORKDIR /usr/src/app

COPY ./frontend ./

RUN npm install

EXPOSE 5173

# Change this line to explicitly set the host
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]