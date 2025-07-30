package Computer;

public class ComputerFacade {
    private final PowerSupply powerSupply = new PowerSupply();
    private final CollingSystem collingSystem = new CollingSystem();
    private final CPU cpu = new CPU();
    private final HardDrive hardDrive = new HardDrive();
    private final Memory memory = new Memory();
    private final Bios bios = new Bios(cpu, memory);
    private final OperatingSystem os = new OperatingSystem();

    public void startComputer() {
        System.out.println("--------Starting Computer--------");
        powerSupply.providePower();
        collingSystem.startFans();
        bios.boot();
        hardDrive.spinUp();
        os.load();
        System.out.println(">-Computer booted successfully!-<");
    }
}