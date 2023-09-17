import { useEffect, useState } from "react";
import { getAllTask } from "../api/task.api";
import { TaskCard } from "./taskCard";

export function TaskList() {
  const [tasks, setTask] = useState([]);

  useEffect(() => {
    async function loadTask() {
      const res = await getAllTask();
      setTask(res.data);
    }
    loadTask();
  }, []);

  return (
    <div className="grid grid-cols-3 gap-3">
      {tasks.map((task) => (
        <TaskCard key={task.id} task={task} />
      ))}
    </div>
  );
}
