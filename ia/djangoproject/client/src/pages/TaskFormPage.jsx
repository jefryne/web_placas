import { useForm } from "react-hook-form";
import { useEffect } from "react";
import { createTask, deleteTask, updateTask, getTask } from "../api/task.api";
import { useNavigate, useParams } from "react-router-dom";
import Toaster, { toast } from "react-hot-toast";

export function TaskFormPage() {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
  } = useForm();
  const navigate = useNavigate();
  const params = useParams();
  console.log(params);

  const onSubmit = handleSubmit(async (data) => {
    console.log(data.local_img)
    if (params.id) {
      await updateTask(params.id, data);
      toast.success("tarea actualizada", {
        position: "bottom-right",
        style: {
          background: "#101010",
          color: "#fff",
        },
      });
    } else {
      await createTask(data);
      toast.success("tarea creada", {
        position: "bottom-right",
        style: {
          background: "#101010",
          color: "#fff",
        },
      });
    }
    navigate("/tasks");
  });

  useEffect(() => {
    async function loadTask() {
      if (params.id) {
        const res = await getTask(params.id);
        setValue("title", res.data.title);
        setValue("url", res.data.url);
      }
    }
    loadTask();
  }, []);

  return (
    <div className="max-w-xl mx-auto">
      <form onSubmit={onSubmit}>
        <input
          type="text"
          placeholder="title"
          {...register("title", { required: true })}
          className="bg.zinc-700  p-3 rounded-lg block w-full mb-3 text-blue-500"
        />
        {errors.title && <span>cammpo reuerido</span>}
        <textarea
          rows="3"
          placeholder="url"
          {...register("url", { required: true })}
          className="bg.zinc-700 p-3 rounded-lg block w-full mb-3 text-blue-500"
        ></textarea>
        {errors.url && <span>cammpo reuerido</span>}


        <button className="bg-indigo-500 p-3 rounded-lg block w-full mt-3">
          save
        </button>
      </form>

      {params.id && (
        <div className="flex justify-end">
          <button
            className="bg-red-500 p-3 rounded-lg w-48 mt-3"
            onClick={async () => {
              const aceptar = window.confirm("estas seguro");
              if (aceptar) {
                await deleteTask(params.id);
                toast.success("tarea actualizada", {
                  position: "bottom-right",
                  style: {
                    background: "#101010",
                    color: "#fff",
                  },
                });
                navigate("/tasks");
              }
            }}
          >
            delete
          </button>
        </div>
      )}
    </div>
  );
}
