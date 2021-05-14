package com.jowell.dao.role;

import com.jowell.dao.DruidDao;
import com.jowell.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ThreePure
 * @date 20/12/2 19:18
 * @description:TODO
 * @since 1.8
 */
public class RoleDaoImpl implements RoleDao {
   
    @Override
    /**
    * @Author: JoWell
    * @Description: 获取角色列表实现类
    * @DateTime: 10:13 2021/4/19
    * @Parameter: [connection]
    * @Return: java.util.List<com.jowell.pojo.Role>
    */
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        ArrayList<Role> roleList = new ArrayList<Role>();

        if (connection != null) {
            String sql = "select * from smbms_role";
            Object[] params = {};
            resultSet = DruidDao.execute(connection, pstm, resultSet, sql, params);
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRoleCode(resultSet.getString("roleCode"));
                role.setRoleName(resultSet.getString("roleName"));
                roleList.add(role);
            }
            DruidDao.closeResource(resultSet, pstm, null);
        }
        return roleList;
    }

}
