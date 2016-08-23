package com.cobble.engine

import org.lwjgl._
import org.lwjgl.glfw._
import org.lwjgl.glfw.GLFW._
import org.lwjgl.opengl._
import org.lwjgl.opengl.GL11._
import org.lwjgl.system.MemoryUtil

trait MainGame extends App {

    def WINDOW_NAME: String

    def DEFAULT_HEIGHT: Int

    def DEFAULT_WIDTH: Int

    private var window: Long = _

    try {
        setNatives()
        initGLFW()
        initGL()
        while(!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
            glfwSwapBuffers(window)
            loop()
            glfwPollEvents()
        }
    } finally {
        destroy()
    }


    def setNatives(debug: Boolean = true): Unit = {
        System.setProperty("org.lwjgl.util.Debug", debug.toString)
    }

    def initGLFW(): Unit = {
        GLFWErrorCallback.createPrint(System.err).set()
        if(!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW")

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3)
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        window = glfwCreateWindow(DEFAULT_WIDTH, DEFAULT_HEIGHT, WINDOW_NAME, MemoryUtil.NULL, MemoryUtil.NULL)
        if (window == MemoryUtil.NULL)
            throw new RuntimeException("Failed to create the GLFW window")

        glfwSetKeyCallback(window, new GLFWKeyCallback {
            override def invoke(window: Long, key: Int, scancode: Int, action: Int, mods: Int): Unit = {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                    glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
            }
        })

        val vidMode: GLFWVidMode = glfwGetVideoMode(glfwGetPrimaryMonitor())

        glfwSetWindowPos(window, (vidMode.width() - DEFAULT_WIDTH) / 2, (vidMode.height() - DEFAULT_HEIGHT) / 2)

        glfwMakeContextCurrent(window)

        glfwSwapInterval(1) //V-sync

        glfwShowWindow(window)
    }

    def initGL(): Unit = {
        GL.createCapabilities()
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
    }

    def loop(): Unit

    def destroy(): Unit = {
        glfwTerminate()
        glfwSetErrorCallback(null).free()
    }


}