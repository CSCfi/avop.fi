# Build frontend
FROM node:14-alpine AS nodebuild
ARG FRONTEND_NAME

WORKDIR /${FRONTEND_NAME}-build/
COPY /${FRONTEND_NAME}/ .
RUN npm install && npm rebuild node-sass && npm run build


#Build actual runtime container
FROM nginxinc/nginx-unprivileged:1.21-alpine AS runtime
ARG FRONTEND_NAME
ARG FRONTEND_PATH

WORKDIR /usr/share/nginx/html/
COPY --from=nodebuild /${FRONTEND_NAME}-build/build/ ./${FRONTEND_PATH}
COPY nginx/nginx.conf.template /etc/nginx/templates/default.conf.template
