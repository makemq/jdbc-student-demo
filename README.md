# jdbc-student-demo

基于 Java 17、Maven、JDBC 和 MySQL 的学生信息管理示例，按 DAO、Service、Controller 三层组织。

## 1. 数据表

执行项目根目录下的 `schema.sql`，创建 `student_db.student` 表。字段为：

- `id`：自增学号（主键）
- `name`：姓名
- `age`：年龄
- `score`：成绩（业务层限制为 0～100）

## 2. 数据库连接

默认连接地址为 `jdbc:mysql://localhost:3306/student_db`，默认用户名和密码为 `root`。建议通过环境变量配置：

- `DB_URL`
- `DB_USER`
- `DB_PASSWORD`

## 3. 运行

确保 MySQL 已启动并已执行 `schema.sql`，然后在项目根目录运行：

```bash
mvn compile
mvn exec:java
```

## 4. 功能

- DAO：`findAll`、`findById`、`addStudent`、`updateStudent`、`deleteStudent`
- Service：调用 DAO，并校验姓名、年龄及 0～100 的成绩范围
- Controller：执行操作并输出成功或失败信息
- Main：依次查询、新增、修改成绩、按学号查询、删除、再次查询

新增学生时学号由数据库自增生成。