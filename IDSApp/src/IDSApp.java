import com.daoimpl.PortScanDaoImpl;
import com.entities.PortScan;
import com.util.ConnectionConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IDSApp {

    public static void main(String[] args) {

        PortScanDaoImpl pdi = new PortScanDaoImpl();
        //pdi.createPortScanTable();

        /*
        You can provide the firstName and lastName to be inserted into the table.
        The Id attribute is auto incremented.
         */
        /*PortScan portScan = new PortScan("Tushar","Sonawane");
        pdi.insert(portScan);*/

        /*
        Select a single record: You can change the Id in the bracket to retrieve the row based on that Id
         */
      /*  PortScan portScan = pdi.selectById(1);
        System.out.println(portScan.getId() + ", " + portScan.getFirstName() + ", " + portScan.getLastName());
        */

        //pdi.delete(3);
        /*
        Select all records from the table. A list of Portscan objects is returned from the selectALL() method
        which is stored in portScans list.
         */

        PortScan portScan = new PortScan("SJSU", "University");
        pdi.update(portScan,1);

        List<PortScan> portScans = pdi.selectAll();
        for(PortScan portScanValues:portScans)
        {
            System.out.println(portScanValues.getId()+", " + portScanValues.getFirstName()+ ", " + portScanValues.getLastName());
        }


       /* java.sql.Connection connection = null;
        try
        {
            connection = ConnectionConfiguration.GetConnection();
            if(connection != null)
            {
                System.out.println("Connection Established !");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(connection != null)
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
        }*/
    }

}
