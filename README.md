# First_join_command  
#### 功能：
 - [X] 玩家首次进服执行命令
#### 配置文件： 
config.yml 
```
#执行命令延迟，如果工作异常请适当调大
# 单位tick 20tick=1秒
delay: 100
#玩家首次进服执行命令
#@p加上英文双引号，可支持带空格的玩家名称
#后面加上&con代表控制台权限执行
command:
  - tell "@p" 欢迎！&con
  - say "@p"首次进入服务器！&con
  - me 大家好
  - give "@p" 264:0 1&con
```
player.yml 存储数据用，无需更改