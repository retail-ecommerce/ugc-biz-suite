java -jar ~/githome/splitter.jar ugc
cd ~/githome/ugc-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/ugc-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/ugc-biz-suite/bizui&& yarn install && yarn build && cd ../../
cd ~/githome/ugc-biz-suite/ && rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/ugc/
cd ~/githome/ugc-biz-suite/bizui && rsync -avz   dist/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps/ROOT/admin/ugc/
ssh philipz@philip.doublechaintech.cn "mysql -uroot -p0254891276 -h 127.0.0.1 < resin-3.1.12/webapps/ugc/WEB-INF/ugc_core_src/META-INF/ugc_mysql.sql"

