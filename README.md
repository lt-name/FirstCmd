# First_join_command  
#### 功能：
 - [X] 玩家首次进服执行命令(控制台权限)  
#### 配置文件： 
config.yml 
```
#执行命令延迟，如果工作异常请适当调大
# 单位task 20task=1秒
delay: 100
#玩家首次进服执行命令 控制台权限
#@p加上英文双引号，可支持带空格的玩家名称
command:
  - tell "@p" 欢迎！
  - say "@p"首次进入服务器！
  - give "@p" 264:0 1
```
player.yml存储数据用，无需更改