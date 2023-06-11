package cn.knightzz.future.api;

import cn.knightzz.future.entity.RpcResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 王天赐
 * @title: CompletableFuture
 * @projectName interview-questions
 * @description:
 * @website <a href="https://knightzz.cn/">https://knightzz.cn/</a>
 * @github <a href="https://github.com/knightzz1998">https://github.com/knightzz1998</a>
 * @create: 2023-06-11 11:42
 */
@SuppressWarnings("all")
@Slf4j
public class CompletableFutureTest {

    /**
     * 基本使用
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void demo01() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture = new CompletableFuture<>();

        Thread t1 = new Thread(() -> {

            RpcResponse<String> response = new RpcResponse<>();
            response.setData("这是数据结果");
            response.setCode("200");
            response.setMsg("success");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 传入执行结果
            resultFuture.complete(response);

        }, "t1");

        t1.start();

        while (!resultFuture.isDone()) {
            log.info("当前任务尚未完成 !");
            Thread.sleep(100);
        }

        RpcResponse<String> response = resultFuture.get();
        log.info("result : {}", response);
    }

    /**
     * 静态工厂方法
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void demo02() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture = new CompletableFuture<>();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaa";
        });

        String s = result.get();
        log.info("supplyAsync : {}", s);
    }

    @Test
    public void demo03() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture = new CompletableFuture<>();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaa";
        }).thenApply((value) -> {
            log.info("thenApply ==> {} ", value);
            return "aaa" + "," + "bbb";
        });

        String s = result.get();
        log.info("supplyAsync : {}", s);
    }

    @Test
    public void demo04() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture = new CompletableFuture<>();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
                int i = 1 / 0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaa";
        }).handle((r, e) -> {
            log.info("result : {} , error : {}", r, e);
            return r != null ? r : "error";
        });
        String s = result.get();
        log.info("supplyAsync : {}", s);
    }

    @Test
    public void demo05() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture01 = new CompletableFuture<>();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaa";
        }).thenCompose(r -> {
            return CompletableFuture.supplyAsync(() -> {
                if (r.equals("aaa")) {
                    return "success";
                }
                return "error";
            });
        });
        String s = result.get();
        log.info("thenCompose : {}", s);
    }

    @Test
    public void demo06() throws ExecutionException, InterruptedException {
        CompletableFuture<RpcResponse<String>> resultFuture01 = new CompletableFuture<>();
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "aaa";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync ... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "bbb";
        }), (r1, r2) -> {
            log.info("result1 : {} , result2 : {}", r1, r2);
            return r1 + " : " + r2;
        });
        String s = result.get();
        log.info("thenCombine : {}", s);
    }
}
