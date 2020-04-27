'use strict';
window.addEventListener('load', function () {

    function creatTask(task) {
        let div = document.getElementById("task");
        let ul = document.createElement('ul');
        let li = document.createElement("li");
        ul.setAttribute("class", "main");
        li.setAttribute("id", "taskId");
        li.setAttribute("class", task.isActive ? "word" : "change")
        li.innerHTML = task.task;
        ul.append(li);
        div.append(ul);
        li.addEventListener('dblclick', function (e) {
            getId(task.id);
            fetch("http://localhost:9797/tasks/" + task.id, {
                                method: "POST"
                            }).then(res => getTask())
        });


    }
    let taskId;
    function getId(id) {
        taskId = id;
    }

    console.log(taskId);

    // let task = document.document.getElementsByClassName("main")
    // let change = document.document.getElementById("taskId")
    // for (let i = 0; i < task.length; i++) {
    //     change[i].addEventListener('dblclick', function (event) {
    //         change.classList.remove("word");
    //         change.classList.toggle("change");
    //         setTimeout(function () {
    //             console.log(taskId);
    //
    //             fetch("http://localhost:9797/" + taskId, {
    //                 method: "GET"
    //             }).then(res => res.json())
    //         }, 1000)
    //     })
    // }

        getTask();
    const value = document.getElementById('value');
    const saveButton = document.getElementById("save-task");
    saveButton.addEventListener("click", function () {
        value.focus();
        if(value.value.trim() !== ""){
            const taskForm = document.getElementById("task-form");
            let data = new FormData(taskForm);
            fetch("http://localhost:8080/create", {
                method: 'POST',
                body: data
            }).then(() => getTask());
        }
        value.value = "";

    });

    function getTask() {
        const tasks = fetch("http://localhost:8080/tasks", {
           method: "GET"
        }).then(response => response.json());

        tasks.then(result => {
            result.forEach(task => {
                creatTask(task);
            })
        })
    }









});
