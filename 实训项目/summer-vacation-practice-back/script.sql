create table classtable
(
    class_no      int                   not null comment '班级号',
    class_order   int                   not null comment '第几节课',
    class_weekday varchar(255)          not null comment '周几',
    sub_no        int unsigned zerofill null comment '课程号',
    tea_no        int unsigned zerofill null comment '教师工号',
    primary key (class_no, class_order, class_weekday)
)
    charset = utf8;

create index ClassNo
    on classtable (class_no);

create index classtable_subject__fk
    on classtable (sub_no);

create index classtable_teacher__fk
    on classtable (tea_no);

create table college
(
    co_no   int          not null comment '学院号'
        primary key,
    co_name varchar(255) null comment '学院名'
)
    charset = utf8;

create table grade
(
    stu_no int    not null comment '学号',
    sub_no int    not null comment '课程号',
    grade  double null comment '成绩',
    primary key (stu_no, sub_no)
)
    charset = utf8;

create table student
(
    stu_no   int(255) unsigned zerofill auto_increment comment '学号'
        primary key,
    stu_name varchar(255)          not null comment '姓名',
    stu_sex  varchar(255)          null comment '性别',
    stu_year year                  null comment '入学年',
    ter_no   int unsigned zerofill null comment '专业号'
)
    charset = utf8;

create table classtostudent
(
    class_no int                                  not null comment '班级号',
    stu_no   int(255) unsigned zerofill default 0 not null comment '学号'
        primary key,
    constraint classtostudent_student__fk
        foreign key (stu_no) references student (stu_no)
)
    charset = utf8;

create index student_teacher__fk
    on student (ter_no);

create table teacher
(
    tea_no     int unsigned zerofill auto_increment comment '教师工号'
        primary key,
    tea_col_no int          null comment '学院号',
    tea_name   varchar(255) null comment '教师姓名',
    tea_level  varchar(255) null comment '教师职称'
)
    charset = utf8;

create table class
(
    class_no int unsigned zerofill auto_increment comment '班级号'
        primary key,
    ter_no   int unsigned zerofill null comment '专业号',
    co_no    int                   null comment '学院号',
    constraint class_college__fk
        foreign key (co_no) references college (co_no),
    constraint class_teacher__fk
        foreign key (ter_no) references teacher (tea_no)
)
    charset = utf8;

create table report
(
    re_no       int unsigned zerofill auto_increment comment '报告号'
        primary key,
    stu_no      int(255) unsigned zerofill null comment '学号',
    tea_no      int unsigned zerofill      null comment '教师工号',
    re_location varchar(255)               null comment '文件地址（相对）',
    upload_date datetime                   null comment '上传时间',
    constraint report_student__fk
        foreign key (stu_no) references student (stu_no),
    constraint report_teacher__fk
        foreign key (tea_no) references teacher (tea_no)
)
    charset = utf8;

create table subject
(
    sub_no   int unsigned zerofill auto_increment comment '课程号'
        primary key,
    tea_no   int unsigned zerofill null comment '教师工号',
    sub_name varchar(255)          not null comment '课程名',
    constraint subject_teacher__fk
        foreign key (tea_no) references teacher (tea_no)
)
    charset = utf8;

create table terminology
(
    ter_no   int unsigned zerofill auto_increment comment '专业号'
        primary key,
    ter_name varchar(255) null comment '专业名称'
)
    charset = utf8;

create table user
(
    user_id  int auto_increment comment '用户编号'
        primary key,
    username varchar(255)               null comment '用户名',
    password varchar(255)               null comment '密码，用md5码存储',
    power    varchar(255)               null comment 'teacher/admin/student',
    tea_no   int unsigned zerofill      null comment '教师工号，为教师时填写',
    stu_no   int(255) unsigned zerofill null comment '学生学号，为学生时填写'
)
    charset = utf8;

create index userform_student__fk
    on user (stu_no);

create index userform_teacher__fk
    on user (tea_no);


