    class Job
    {
      Device targetDevice;
      int Pages;
      bytes[] data;
      JobStatus Status;
    }
    enum JobStatus {}
    eunm DeviceStatus {}
    enum DeviceType {}

    class Device
    {
      string Name;
      DeviceType Type;
      DeviceStatus Status;
      string Description;
      //properties
    }

    class Printer : Device
    {
       public void Print();
    }

    class Scheduler
    {
      List<Device> Devices;
      List<Job> Jobs;
    }
