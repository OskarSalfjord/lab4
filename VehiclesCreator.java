import java.awt.*;

public class VehiclesCreator {
    Volvo240 createVolvo240(Color color, double x, double y, double direction) {
        return new Volvo240(color, x ,y ,direction);}
    Saab95 createSaab95(Color color, double x, double y, double direction) {
        return new Saab95(color, x ,y ,direction);}
    Scania createScania(Color color, double x, double y, double direction) {
        return new Scania(color, x ,y ,direction);}
    Cartransporter3000 createCartransporter3000(Color color, double x, double y, double direction) {
        return new Cartransporter3000(color, x ,y ,direction);}
}
