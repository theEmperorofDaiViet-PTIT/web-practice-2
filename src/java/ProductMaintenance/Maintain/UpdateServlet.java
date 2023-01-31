package ProductMaintenance.Maintain;

import ProductMaintenance.DB.ProductIO;
import ProductMaintenance.business.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/updateProduct"})
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //Default
        String url = "/updateProduct.jsp";
        Product editProduct = null;
        String message = null;        
        String action = request.getParameter("action");
        if(action == null){
            action = "updateRequest";
        }
        //Khi nguoi dung gui request them/sua
        if(action.equals("updateRequest")){
            String code = request.getParameter("productCode");
            editProduct = ProductIO.search(code);
            request.setAttribute("editProduct", editProduct);
        }
        //Sau khi nguoi dung submit form
        if(action.equals("update")){
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String p = request.getParameter("price");
            double price = 0;
            String productCode = request.getParameter("productCode");
            Product userInput = new Product();
            // Validate productCode nguoi dung nhap vao
            if(code.isEmpty() || code == null){
                url = "/updateProduct.jsp";
                message = "You must enter a code for the product.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher(url).forward(request, response);                
                return;                
            }
            //Validate productDescription nguoi dung nhap vao
            if(description.isEmpty() || description == null){
                url = "/updateProduct.jsp";
                message = "You must enter a description for the product.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher(url).forward(request, response);                
                return;                
            }
            //Validate price nguoi dung nhap vao
            if(p.isEmpty() || p == null){
                url = "/updateProduct.jsp";
                message = "You must enter a price for the product.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher(url).forward(request, response);                
                return;                
            }
            //Kiem tra price la so
            try{
                price = Double.parseDouble(p);
            }
            catch(NumberFormatException e){
                userInput = new Product(code, description, price);
                request.setAttribute("userInput", userInput);
                url = "/updateProduct.jsp";
                message = "Please enter a number!";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher(url).forward(request, response);                
                return;
            }
            //Kiem tra request la them hay sua
            if(productCode == null){
                if(ProductIO.search(code) == null){
                    ProductIO.add(code, description, price);
                    url = "/thanks.jsp";
                }
                else{
                    ProductIO.edit(code, description, price, code);
                    url = "/thanks.jsp";
                }
            }
            else{
                ProductIO.edit(code, description, price, productCode);
                url = "/thanks.jsp";
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
