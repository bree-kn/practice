package com.example.practice.mybatis;

/**
 * 1.返回一个值基本类型包装类型均可以，resulttype:string,int,Integer...
 *     <select id="test" resultType="string">
 *         select name from t_tax where id=1
 *     </select>
 * 2.返回2个或多个resulttype用map,获取的时候直接map.get("name").tostring即可以
 *     <select id="test" resultType="map">
 *         select name,status from t_tax where id=1
 *     </select>
 * 3.返回一个实体类,如果实体类的某个属性的名字和表里字段名字不一致时，用resultmap，如果一致的话，则用（resulttype=实体类名）即可
 *     <resultMap id="thismap" type="com.aicreate.common.domain.TTax">
 *         <result property="id" column="id"></result>
 *         <result property="name" column="name"></result>
 *         <result property="status" column="status"></result>
 *         <result property="displayName" column="display_name"></result>------displayName，display_name
 *     </resultMap>
 *     <select id="test" resultMap="thismap">
 *         select * from t_tax where id=1
 *     </select>
 *     其实集合和返回单体是一致的，
 *     返回一个string值和返回一个string集合，则resulttype->string
 *     返回一个实体类和返回一个实体类集合，则resulttype->TTax,或resultmap->TTax
 *     返回一个map值和返回一个map集合，则resulttype->map
 * 4.返回一个实体类集合的话，如果属性名字和表字段名称不一致，还是用resultmap,不过返回类型不能在sql中写List<TTax>,写TTax即可，即type="com.aicreate.common.domain.TTax"
 * <resultMap id="resmap" type="com.aicreate.common.domain.TTax">
 *     <result property="id" column="id"></result>
 *     <result property="name" column="name"></result>
 *     <result property="status" column="status"></result>
 *     <result property="displayName" column="display_name"></result>
 * </resultMap>
 *
 *     <select id="test" resultMap="resmap">
 *         select * from t_tax
 *     </select>
 * 5.返回一个string集合的话，resulttype可以写成string,不能写成List<String>,即可以resultType="string"
 *   <select id="test" resultType="string">
 *         select name from t_tax
 *   </select>
 *  6.mybatis一对一<association></>
 *    一对多<collection></>
 *    多对对
 *  <select id="getRoomIdBySubjectid" resultType="long">
 *      select roomid from xxx where id=#{subjectid}
 *  </select>
 *  <select id="getTaxNameListById" resultType="string">
 *      select a.`name` from t_tax a inner join t_tax_reation_subject b on a.id = b.tax_id where b.subject_id = #{subjectid}
 *  </select>
 *  <resultMap id="myQaCollect" type="com.aicreate.expert.app.dto.MyCollectQuestionDTO">
 *      <result column="subjectid" property="subid"></result>//column是指sql语句中的字段名或别名，property是指实体类的名字。
 *      <result column="title" property="title"></result>
 *      <result column="name" property="name"></result>
 *      <association  property="roomid" column="subjectid" select="getRoomIdBySubjectid"></result>//此处的column是指传入查询语句的参数，如果是多个参数则可以column="{prop1=col1,prop2=col2}"
 *      <collection property="taxnamelist" column="subjectid" select="getTaxNameListById"></collection>//所以此处的column里边的字段一定在sql语句中查询出，否则不能进行查询一对一，一对多
 *  </>
 *  <select id="getMyQuestionCollect" resultMap="myQaCollect">
 *      select id as subjectid,//此字段必须查询出来对应association,collection中的column
 *              title,
 *              name,
 *              roomid
 *      from t_subject where type='1'
 *  </>
 *  7.#{},${}
 *  #{}:预编译的，防止sql注入，编译好sql后再取值。select * from xxx where id=#{id}
 *  ${}:取值后再去编译sql语句。
 *  8.sql语句中_下划线表示匹配所有的字符，即可以查询到所有的字符，相当于count(*),可以加转义字符即可‘\’
 *  select id,name from kb_app where name like '%\_%'
 *  9.count
 *  count(*)包括了所有的列，相当于行数，在统计结果的时候，不会忽略列值为NULL
 *  count(1)包括了忽略所有列，用1代表代码行，在统计结果的时候，不会忽略列值为NULL
 *  count(列名)只包括列名那一列，在统计结果的时候，会忽略列值为空（这里的空不是只空字符串或者0，而是表示null）的计数，即某个字段值为NULL时，不统计。
 *  10.获取刚才插入的key
 *     @Insert("insert into t_agent(agent_name,province_name,is_delete,create_id,create_time,merchant_id,status,contact_name,update_id,update_time) values(#{agentName},#{provinceName},#{isDelete},#{createId},#{createTime},#{merchantId},#{status},#{contactName},#{createId},#{createTime})")
 *     @SelectKey(before = false, keyProperty = "id", resultType = Long.class, statement = { "select id from t_agent where agent_name = #{agentName}" })
 *     boolean insertAgent(AgentDTO agentdto);
 *      用@SelectKey注解即可查出刚才插入的key，select last_insert_id()适合主键自增的，非自增的可以用上边的代码
 *
 *
 *
 */

public class mybatis {
    //因为此处的$是正则表达式的结尾，所以需要给其转义才可以，其他的不用转义。
    public static void main(String[] args) {
        String s = "123$#$456$#$789";
        String[] arr = s.split("\\$#\\$");
        for(String aa : arr){
            System.out.println(aa);
        }
        try {
            throw new Exception("this is test aa");
        } catch (Exception e) {
            System.out.println("aa");
//            e.printStackTrace();
        }
    }
}
