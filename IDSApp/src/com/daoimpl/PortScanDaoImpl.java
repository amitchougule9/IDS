package com.daoimpl;

import com.dao.PortScanDao;
import com.entities.PortScan;
import com.util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
PortScanDaoImpl class implements the interface PortScanDao. Tis is where we define all the methods for
Create, Insert, Select by Id, Select all, Delete and Update.
 */
public class PortScanDaoImpl implements PortScanDao{
    @Override
    public void createPortScanTable() {
        Connection connection = null;
        Statement statement = null;

        try
        {
            connection = ConnectionConfiguration.GetConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS PortScan_1(Id int primary key unique auto_increment," +
                    "firstName varchar(50), lastName varchar(50) ) ");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (statement != null)
            {
                try{
                    statement.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void insert(PortScan portScan) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.GetConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO portscan_1 (firstName, lastName) " +
                    "VALUES (?,?)");
            preparedStatement.setString(1,portScan.getFirstName());
            preparedStatement.setString(2,portScan.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO portscan_1 (firstName, lastName) VALUES (?,?)");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public PortScan selectById(int Id) {
        PortScan portScan = new PortScan();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.GetConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM portscan_1 WHERE Id = ?");
            preparedStatement.setInt(1, Id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                portScan.setId(resultSet.getInt("Id"));
                portScan.setFirstName(resultSet.getString("firstName"));
                portScan.setLastName(resultSet.getString("lastName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null)
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return portScan;
    }

    @Override
    public List<PortScan> selectAll() {

        List<PortScan> portScans = new ArrayList<PortScan>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.GetConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM portscan_1");

            while(resultSet.next())
            {
                PortScan portScan = new PortScan();
                portScan.setId(resultSet.getInt("Id"));
                portScan.setFirstName(resultSet.getString("firstName"));
                portScan.setLastName(resultSet.getString("lastName"));

                portScans.add(portScan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return portScans;
    }

    @Override
    public void delete(int Id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;



        try {
            connection = ConnectionConfiguration.GetConnection();
            preparedStatement = connection.prepareStatement("DELETE from portscan_1 WHERE Id = ?");
            preparedStatement.setInt(1,Id);
            preparedStatement.executeUpdate();
            System.out.println("DELETE from portscan_1 WHERE Id = ?");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    /*
    Takes two arguments - a PortScan instance (basically a new person) and the Id to be updated with this
    new person
     */
    public void update(PortScan portScan, int Id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.GetConnection();
            preparedStatement = connection.prepareStatement("UPDATE portscan_1 SET " +
                    "firstName = ?, lastName = ? WHERE Id = ?");
            preparedStatement.setString(1,portScan.getFirstName());
            preparedStatement.setString(2,portScan.getLastName());
            preparedStatement.setInt(3,Id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE portscan_1 SET " +
                    "firstName = ?, lastName = ? WHERE Id = ?");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
