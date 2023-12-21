# ScaffoldingDDD

Scaffolding Engineering based on DDD thinking and spring Framework  
基于Spring框架 搭建DDD 领域驱动设计分层架构的脚手架WEB工程.

### 包结构

- common 公共模块, 后面有可能抽取到独立的项目中，供各个微应用复用
- domain 领域模型
- adapter 应用适配器, 定义与外部系统交互的各类方式的接口, 包含相互调用
- infrastructure 基础设施
- infrastructure.adapter 基础设施适配器, 定义与外部系统交互的各类方式的接口, 包含相互调用
- application 应用层, 定义应用程序提供的功能（用例）
- test 测试

### 项目中包含的例子业务功能

用户登录
用户注册
用户角色管理
用户权限管理
用户角色权限管理
用户角色权限分配
用户角色