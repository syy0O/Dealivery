FROM nginx:latest
ADD ./default.conf /etc/nginx/conf.d/default.conf
ADD ./dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]